<template>
  <div class="app-container">
    <el-row>
      <el-col :span="24">
        <el-steps :active="activeSteps" finish-status="success">
          <el-step title="基本信息"></el-step>
          <el-step title="规格参数"></el-step>
          <el-step title="销售属性"></el-step>
          <el-step title="SKU信息"></el-step>
          <el-step title="保存完成"></el-step>
        </el-steps>
      </el-col>
      <el-col :span="24" v-if="activeSteps === 0">
        <el-card>
          <el-form ref="spuBaseInfoForm" :model="spuBaseInfoForm" :rules="spuBaseInfoFormRules" label-width="80px">
            <el-form-item label="商品名称" prop="spuName">
              <el-input v-model="spuBaseInfoForm.spuName" placeholder="请输入商品名称" />
            </el-form-item>
            <el-form-item label="商品描述" prop="spuDescription">
              <el-input type="textarea" v-model="spuBaseInfoForm.spuDescription" placeholder="请输入商品描述" />
            </el-form-item>
            <el-form-item label="分类" prop="catalogId">
              <category-cascader
                :catalog-id="spuBaseInfoForm.catalogId"
                @categoryChange="categoryChange"
              ></category-cascader>
            </el-form-item>
            <el-form-item label="品牌" prop="brandId">
              <brand-select
                :model-brand-id="spuBaseInfoForm.brandId"
                @brandChange="brandChange"
              ></brand-select>
            </el-form-item>
            <el-form-item label="商品重量" prop="weight">
              <el-input-number
                v-model="spuBaseInfoForm.weight"
                :min="0"
                :precision="3"
                :step="0.1"
                style="width: 100%"
              ></el-input-number>
            </el-form-item>
            <el-form-item label="设置积分" prop="bounds">
              <label>金币</label>
              <el-input-number
                style="width:130px"
                placeholder="金币"
                v-model="spuBaseInfoForm.bounds.buyBounds"
                :min="0"
                controls-position="right"
              ></el-input-number>
              <label style="margin-left:15px">成长值</label>
              <el-input-number
                style="width:130px"
                placeholder="成长值"
                v-model="spuBaseInfoForm.bounds.growBounds"
                :min="0"
                controls-position="right"
              >
                <template slot="prepend">成长值</template>
              </el-input-number>
            </el-form-item>
            <el-form-item label="商品介绍" prop="description">
              <multi-upload v-model="spuBaseInfoForm.description"></multi-upload>
            </el-form-item>
            <el-form-item label="商品图集" prop="images">
              <multi-upload v-model=spuBaseInfoForm.images></multi-upload>
            </el-form-item>
            <el-form-item>
              <el-button type="success" @click="handleBaseAttrInfo">下一步</el-button>
            </el-form-item>
          </el-form>
        </el-card>
      </el-col>
      <el-col :span="24" v-if="activeSteps === 1">
        <el-card>
          <el-tabs tab-position="left" style="height: 200px;">
            <el-tab-pane
              v-for="(group, gIdx) in attrGroupWithAttrVo.attrGroupWithBaseAttrVOList"
              :key="gIdx"
              :label="group.attrGroupName"
            >
              <el-form ref="baseAttrForm" :model="baseAttrForm" :rules="baseAttrFormRules">
                <el-form-item
                  v-for="(attr, aIdx) in group.baseAttrInfoList"
                  :key="attr.attrId"
                  :label="attr.attrName"
                >
                  <el-select
                    v-model="attr.attrValues"
                    multiple
                    :multiple-limit="attr.valType === 1 ? 0 : 1"
                    filterable
                    allow-create
                    default-first-option
                    placeholder="请选择或输入值"
                  >
                    <el-option
                      v-for="(val, vIdx) in attr.valueSelect.split(',')"
                      :key="vIdx"
                      :label="val"
                      :value="val"
                    ></el-option>
                  </el-select>
                  <el-checkbox
                    v-model="attr.showDesc"
                    :true-label="1"
                    :false-label="0"
                  >快速展示</el-checkbox>
                </el-form-item>
              </el-form>
            </el-tab-pane>
          </el-tabs>
          <div>
            <el-button type="primary" @click="activeSteps = 0">上一步</el-button>
            <el-button type="success" @click="handleSaleAttrInfo">下一步：设置销售属性</el-button>
          </div>
        </el-card>
      </el-col>
      <el-col :span="24" v-if="activeSteps === 2">
        <el-card>
          <el-form ref="saleAttrForm" :model="saleAttrForm" :rules="saleAttrFormRules">
            <el-form-item
              v-for="(saleAttr, sIdx) in attrGroupWithAttrVo.saleAttrInfoList"
              :key="saleAttr.attrId"
              :label="saleAttr.attrName"
            >
              <el-checkbox-group v-model="saleAttr.attrValues">
                <el-checkbox
                  v-if="saleAttr.valueSelect !== ''"
                  :label="val"
                  v-for="val in saleAttr.valueSelect.split(',')"
                  :key="val"
                ></el-checkbox>
              </el-checkbox-group>
            </el-form-item>
          </el-form>
          <div>
            <el-button type="primary" @click="activeSteps = 1">上一步</el-button>
            <el-button type="success" @click="handleDescartesSkus">下一步：设置SKU信息</el-button>
          </div>
        </el-card>
      </el-col>
      <el-col :span="24" v-if="activeSteps === 3">
        <el-table :data="skuInfoVOList" style="width: 100%">
          <el-table-column label="属性组合">
            <el-table-column
              v-for="(item, index) in skuInfoVOList[0].skuSaleAttrValueList"
              :label="item.attrName"
              :key="index"
            >
              <template slot-scope="scope">
                <span style="margin-left: 10px">{{ scope.row.skuSaleAttrValueList[index].attrValue }}</span>
              </template>
            </el-table-column>
          </el-table-column>

          <el-table-column label="商品名称" prop="skuName">
            <template slot-scope="scope">
              <el-input v-model="scope.row.skuName"></el-input>
            </template>
          </el-table-column>
          <el-table-column label="标题" prop="skuTitle">
            <template slot-scope="scope">
              <el-input v-model="scope.row.skuTitle"></el-input>
            </template>
          </el-table-column>
          <el-table-column label="副标题" prop="skuSubtitle">
            <template slot-scope="scope">
              <el-input v-model="scope.row.skuSubtitle"></el-input>
            </template>
          </el-table-column>
          <el-table-column label="价格" prop="price">
            <template slot-scope="scope">
              <el-input v-model="scope.row.price"></el-input>
            </template>
          </el-table-column>
        </el-table>
        <div>
          <el-button type="primary" @click="activeSteps = 2">上一步</el-button>
          <el-button type="success" @click="handleSubmitSkus">下一步：保存商品信息</el-button>
        </div>
      </el-col>
      <el-col :span="24" v-if="activeSteps === 4">
        <div>
          <h1>添加成功</h1>
          <el-button type="success" @click="addMore">继续添加</el-button>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import CategoryCascader from "@/views/product/category/CategoryCascader";
import BrandSelect from "@/views/product/brand/BrandSelect";
import MultiUpload from "@/views/components/upload/MultiUpload";
import {descartesSkuList, saveSkuList} from "@/api/product/skuInfo";
import {getAttrGroupWithAttrVo} from "@/api/product/group";

export default {
  name: "SpuAdd",
  components: {
    CategoryCascader,
    BrandSelect,
    MultiUpload
  },
  data() {
    return {
      activeSteps: 0,
      spuBaseInfoForm: {},
      spuBaseInfoFormRules: {
        spuName: [
          {required: true, message: '名称不能为空', trigger: 'blur'}
        ],
        spuDescription: [
          {required: true, message: '描述不能为空', trigger: 'blur'}
        ],
        catalogId: [
          {required: true, message: '请选择分类', trigger: 'change'}
        ],
        brandId: [
          {required: true, message: '请选择品牌', trigger: 'change'}
        ],
        weight: [
          {required: true, message: '重量不能为空', trigger: 'blur'}
        ],
/*        description: [
          {required: true, message: '商品介绍不能为空', trigger: 'blur'}
        ]*/
      },
      baseAttrForm: {},
      baseAttrFormRules: {},
      saleAttrForm: {},
      saleAttrFormRules: {},
      attrGroupWithAttrVo: {
        attrGroupWithBaseAttrVOList: [],
        saleAttrInfoList: []
      },
      skuInfoVOList: []
    }
  },
  created() {
    this.handleReset();
  },
  methods: {
    handleReset() {
      this.spuBaseInfoForm = {
        weight: 0,
        catalogId: null,
        brandId: null,
        bounds: {
          buyBounds: null,
          growBounds: null
        },
        description: ['1','1'],
        images: ['1']
      }
      this.resetForm("spuBaseInfoForm");
    },
    handleBaseAttrInfo() {
      getAttrGroupWithAttrVo({catalogId: this.spuBaseInfoForm.catalogId}).then(res => {
        this.attrGroupWithAttrVo = res.data;
        console.log(res.data)
      });
      this.activeSteps = 1;
    },
    handleSaleAttrInfo() {
      this.activeSteps = 2;
    },
    handleDescartesSkus() {
      let data = {
        catalogId: this.spuBaseInfoForm.catalogId,
        brandId: this.spuBaseInfoForm.brandId,
        skuName: this.spuBaseInfoForm.spuName,
        saleAttrInfoList: this.attrGroupWithAttrVo.saleAttrInfoList
      }
      descartesSkuList(data).then(res => {
        this.skuInfoVOList = res.data;
        console.log(res.data)
      });
      this.activeSteps = 3;
    },
    handleSubmitSkus() {
      let spuDto = {
        spuInfoDTO: this.spuBaseInfoForm,
        baseAttrInfoList: this.attrGroupWithAttrVo.attrGroupWithBaseAttrVOList,
        skuInfoVoList: this.skuInfoVOList
      }
      saveSkuList(spuDto).then(res => {
        this.$modal.msg("添加成功");
      });
      this.activeSteps = 4;
    },
    addMore() {
      this.activeSteps = 0;
    },
    categoryChange(data) {
      this.spuBaseInfoForm.catalogId = data;
    },
    brandChange(data) {
      this.spuBaseInfoForm.brandId = data;
    }
  }
}
</script>

<style scoped>

</style>
