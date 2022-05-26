package com.gulimall.file.utils;

import com.gulimall.common.core.utils.DateUtils;
import com.gulimall.common.core.utils.StringUtils;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.file.domain.MinioVO;
import io.minio.*;
import io.minio.errors.*;
import io.minio.messages.DeleteError;
import io.minio.messages.DeleteObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gwoksing
 * @date 2022/5/26 16:06
 */
@Slf4j
@Component
public class MinioUtils {
    @Value("${minio.bucketName}")
    private String bucketName;
    @Value("${minio.endpoint}")
    private String endpoint;

    @Autowired
    private MinioClient minioClient;

    /**
     * 查看存储bucket是否存在
     *
     * @param bucketName 存储bucket
     * @return boolean
     */
    public Boolean bucketExists(String bucketName) {
        Boolean found;
        try {
            found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return found;
    }

    /**
     * 创建存储bucket
     *
     * @param bucketName 存储bucket名称
     * @return Boolean
     */
    public Boolean makeBucket(String bucketName) {
        try {
            minioClient.makeBucket(MakeBucketArgs.builder()
                    .bucket(bucketName)
                    .build());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 删除存储bucket
     *
     * @param bucketName 存储bucket名称
     * @return Boolean
     */
    public Boolean removeBucket(String bucketName) {
        try {
            minioClient.removeBucket(RemoveBucketArgs.builder()
                    .bucket(bucketName)
                    .build());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 文件上传
     *
     * @param file 文件
     * @return path
     */
    public MinioVO upload(MultipartFile file, String path) {
        MinioVO minioVO = new MinioVO();
        String finalPath = StringUtils.isNull(path) ? DateUtils.datePath() + "/" : path + "/";
        String filename = DateUtils.dateTimeNow() + "-" + file.getOriginalFilename();
        try {
            PutObjectArgs objectArgs = PutObjectArgs.builder().bucket(bucketName)
                    .object(finalPath + filename)
                    .stream(file.getInputStream(), file.getSize(), -1)
                    .contentType(file.getContentType())
                    .build();
            //文件名称相同会覆盖
            minioClient.putObject(objectArgs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        minioVO.setPath(finalPath + filename);
        minioVO.setBucketName(bucketName);
        minioVO.setUrl(endpoint + "/" + bucketName + "/" + finalPath + filename);
        minioVO.setFilename(filename);
        return minioVO;
    }

    /**
     * 通过InputStream上传对象https://docs.min.io/docs/java-client-api-reference.html#putObject
     *
     * @param objectName  存储桶里的对象名称
     * @param inputStream 要上传的流
     * @return
     */
    public MinioVO putObjectStream(String objectName, InputStream inputStream, Long fileSize, String path, String contentType) {
        MinioVO minioVO = new MinioVO();
        String finalPath = StringUtils.isNull(path) ? DateUtils.datePath() + "/" : path + "/";
        try {
            PutObjectArgs objectArgs = PutObjectArgs.builder().bucket(bucketName)
                    .object(finalPath + objectName)
                    .stream(inputStream, fileSize, -1)
                    .contentType(contentType)
                    .build();
            //文件名称相同会覆盖
            minioClient.putObject(objectArgs);

        } catch (Exception e) {
            e.printStackTrace();
        }
        minioVO.setPath(finalPath + objectName);
        minioVO.setBucketName(bucketName);
        minioVO.setUrl(endpoint + "/" + bucketName + "/" + finalPath + objectName);
        return minioVO;
    }

    /**
     * 文件下载
     *
     * @param filepath 文件路径
     * @param res      response
     * @return Boolean
     */
    public void download(String filepath, HttpServletResponse res) {
        GetObjectArgs objectArgs = GetObjectArgs.builder().bucket(bucketName)
                .object(filepath).build();
        try (GetObjectResponse response = minioClient.getObject(objectArgs)) {
            byte[] buf = new byte[1024];
            int len;
            try (FastByteArrayOutputStream os = new FastByteArrayOutputStream()) {
                while ((len = response.read(buf)) != -1) {
                    os.write(buf, 0, len);
                }
                os.flush();
                byte[] bytes = os.toByteArray();
                res.setCharacterEncoding("utf-8");
                //设置强制下载不打开
                res.setContentType("application/force-download");
                res.addHeader("Content-Disposition", "attachment;fileName=" + filepath);
                try (ServletOutputStream stream = res.getOutputStream()) {
                    stream.write(bytes);
                    stream.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除一个对象
     *
     * @param objectName 存储桶里的对象名称
     */
    public AjaxResult removeObject(String objectName) throws IOException, InvalidResponseException, NoSuchAlgorithmException, InternalException, XmlParserException, ErrorResponseException, ServerException, InsufficientDataException, InvalidKeyException {
        boolean flag = bucketExists(bucketName);
        if (flag) {
            minioClient.removeObject(RemoveObjectArgs.builder().bucket(bucketName).object(objectName).build());
            return AjaxResult.success();
        }
        return AjaxResult.error();
    }

    /**
     * 删除指定桶的多个文件对象,返回删除错误的对象列表，全部删除成功，返回空列表
     *
     * @param bucketName  存储桶名称
     * @param objectNames 含有要删除的多个object名称的迭代器对象
     * @return eg:
     * List<DeleteObject> objects = new LinkedList<>();
     * objects.add(new DeleteObject("my-objectname1"));
     * objects.add(new DeleteObject("my-objectname2"));
     * objects.add(new DeleteObject("my-objectname3"));
     */
    public List<String> removeObjects(String bucketName, List<DeleteObject> objectNames) throws IOException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, ErrorResponseException, InvalidKeyException {
        List<String> deleteErrorNames = new ArrayList<>();
        boolean flag = bucketExists(bucketName);
        if (flag) {
            Iterable<Result<DeleteError>> results = minioClient.removeObjects(RemoveObjectsArgs.builder().bucket(bucketName).objects(objectNames).build());
            for (Result<DeleteError> result : results) {
                DeleteError error = result.get();
                deleteErrorNames.add(error.objectName());
            }
        }
        return deleteErrorNames;
    }

    /**
     * 上传文件（设置文件名）
     *
     * @param file
     * @param path
     * @param name
     * @return
     */
    public MinioVO uploadFile(MultipartFile file, String path, String name) {
        MinioVO minioVO = new MinioVO();
        String finalPath = StringUtils.isNull(path) ? DateUtils.datePath() + "/" : path + "/";
        try {
            PutObjectArgs objectArgs = PutObjectArgs.builder().bucket(bucketName)
                    .object(finalPath + name)
                    .stream(file.getInputStream(), file.getSize(), -1)
                    .contentType(file.getContentType())
                    .build();
            //文件名称相同会覆盖
            minioClient.putObject(objectArgs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        minioVO.setPath(finalPath + name);
        minioVO.setBucketName(bucketName);
        minioVO.setUrl(endpoint + "/" + bucketName + "/" + finalPath + name);
        minioVO.setBaseUrl(endpoint + "/" + bucketName + "/");
        return minioVO;
    }

    /**
     * 复制文件
     *
     * @param sourcePath
     * @param targetPath
     * @return
     */
    public MinioVO copyFile(String sourcePath, String targetPath) {
        MinioVO minioVO = new MinioVO();
        String msg = "复制成功";
        try {
            minioClient.copyObject(CopyObjectArgs.builder()
                    .source(CopySource.builder()
                            .bucket(bucketName)
                            .object(sourcePath)
                            .build())
                    .bucket(bucketName)
                    .object(targetPath)
                    .build());
            minioVO.setUrl(endpoint + "/" + bucketName + "/" + targetPath);
            minioVO.setBucketName(bucketName);
            minioVO.setPath(targetPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return minioVO;
    }

    /**
     * 取文件上传基本信息
     *
     * @return
     */
    public MinioVO getUploadPath() {
        MinioVO minioVO = new MinioVO();
        minioVO.setBucketName(bucketName);
        minioVO.setBaseUrl(endpoint + "/" + bucketName + "/");
        return minioVO;
    }

    /**
     * 检查文件是否存在
     *
     * @param bucketName
     * @param objectName
     * @return
     */
    public Boolean checkFileIsExist(String bucketName, String objectName) {
        try {
            minioClient.statObject(
                    StatObjectArgs.builder().bucket(bucketName).object(objectName).build()
            );
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}

