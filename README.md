# 基于RuoYi-Cloud3.4的谷粒商城
> status: WIP

### 参与贡献
1. Fork 本仓库
2. 新建 dev_xxx 分支
3. 提交代码
4. 新建 Pull Request

### 提交规范
- feat：新功能（feature）
- fix：修补bug
- docs：文档（documentation）
- style： 格式（不影响代码运行的变动）
- refactor：重构（即不是新增功能，也不是修改bug的代码变动）
- test：增加测试
- chore：构建过程或辅助工具的变动

### 模块说明
```text
gulimall-api -- remote api
gulimall-auth -- 鉴权服务 6200
gulimall-common -- 公共模块
gulimall-gateway -- 网关服务 8080
gulimall-modules
├── gulimall-system -- 系统基础服务 6201
├── gulimall-file -- 文件服务 6300
├── gulimall-job -- 定时任务服务 6203
├── gulimall-gen -- 代码生成服务 6202
├── gulimall-cart -- 购物车服务 40000
├── gulimall-coupon -- 优惠券服务 11000
├── gulimall-order -- 订单服务 9000
├── gulimall-product -- 商品服务 10000
├── gulimall-search -- 检索服务 12000
├── gulimall-seckill -- 秒杀服务 25000
├── gulimall-third-party -- 第三方服务 30000
├── gulimall-ware -- 仓储服务 7000
└── gulimall-member -- 会员服务 8000
gulimall-visual
└── gulimall-monitor -- 服务监控 6100
```
