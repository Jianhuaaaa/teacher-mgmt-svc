# Swagger Requirement

Please implement Swagger for current project initialized with version 1, including:
1. add necessary dependencies to pom.xml file
2. update necessary configuration in resources/application.yml file
3. add swagger configuration class under path com.jsun.teacher.config
4. add swagger implementation to existing controllers under path com.jsun.teacher.controller
5. add detailed swagger information using @Tag、@Operation、@ApiResponse annotations.
6. for API response please provide all the frequently used code and error message.

# Request
Please implements swagger ui for controllers @LessionController.java @TeacherController.java  initialzied with version 1, add necessary changes in file @application.yml @pom.xml , detailed requirement can be found in @Implements.md  

# Response

现在我已经完成了所有必要的Swagger UI配置。让我总结一下所做的更改：

1. 创建了`OpenApiConfig`配置类，设置了API文档的基本信息。
2. 在`application.yml`中添加了springdoc-openapi的配置。
3. 为`TeacherController`和`LessionController`添加了详细的Swagger注解，包括：
   - `@Tag` - 用于API分组
   - `@Operation` - 描述每个API操作
   - `@ApiResponses` - 定义可能的响应状态
   - `@Parameter` - 描述API参数
   - `@Schema` - 定义响应模型

现在您可以通过以下URL访问Swagger UI：
- Swagger UI界面：`http://localhost:8080/swagger-ui.html`
- OpenAPI文档：`http://localhost:8080/api-docs`

每个API端点都包含了详细的文档说明，包括：
- 操作描述
- 请求参数说明
- 响应状态码和说明
- 错误处理信息