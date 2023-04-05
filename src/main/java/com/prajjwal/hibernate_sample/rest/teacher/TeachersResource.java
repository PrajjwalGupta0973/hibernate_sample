//package com.prajjwal.hibernate_sample.rest.teacher;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.prajjwal.hibernate_sample.config.SwaggerConfig;
//import com.prajjwal.hibernate_sample.domain.Teacher;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
//import io.swagger.annotations.Example;
//import io.swagger.annotations.ExampleProperty;
//
//@RestController
//@RequestMapping("/api")
////@SwaggerDefinition(tags = { @Tag(name = "teacher-tag", description = "teacher-tag description"),
////		@Tag(name = "second-teacher-tag", description = "second-teacher-tag description") }, info = @Info(version = "first-teacher-version", title = "TeacherRestResource"))
//@Api(tags = { SwaggerConfig.teacher_description_tag })
//public class TeachersResource {
//
//	@GetMapping(name = "/v1/teachers/{id}", produces = "application/json")
//	@ApiOperation(hidden = false, value = "Get a teacher details by id")
//	@ApiResponses(value = {
//			@ApiResponse(code = 200, message = "Successfully retrieved list", examples = @Example(value = @ExampleProperty(mediaType = "application/json", value = "{\"name\": \"pj\"}"))),
//			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
//			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
//			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
//
//	private ResponseEntity<Teacher> getTeacherById(
//			@ApiParam(name = "t-name", required = true, value = "teacher name req param") @RequestParam("t-name") String teacherName) {
//
//		return ResponseEntity.ok(new Teacher("teacher_id", "teacher_name", "id_appender", 9000));
//	}
//}
