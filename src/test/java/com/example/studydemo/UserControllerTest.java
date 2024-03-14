package com.example.studydemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.example.studydemo.controller.UserController;
import com.example.studydemo.entity.User;
import com.example.studydemo.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    public void testRegisterUser() {
        // 创建一个模拟的用户对象
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("testPassword");

        // 设置模拟userService的行为
        when(userService.registerUser(user)).thenReturn(user);

        // 调用控制器方法
        User registeredUser = userController.registerUser(user);

        // 验证控制器方法是否正确
        assertEquals(user, registeredUser);
    }

    // 可以编写其他测试方法来测试其他功能，如getUserByUsername、updateUser、deleteUser等
}
