//package za.ac.cput.service;
//
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import za.ac.cput.domain.Admin;
//import za.ac.cput.factory.AdminFactory;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//
//class AdminServiceTest {
//    @Autowired
//    private AdminService adminService;
//
//    private Admin admin = AdminFactory.createAdmin(
//            123L,
//            "John",
//            "Doe",
//            "Johnd@cput.ac.za",
//            "@Johndoe123"
//    );
//
//    @Test
//    @Order(1)
//    void create() {
//        Admin create = adminService.create(admin);
//        assertNotNull(create);
//        System.out.println("Created: " + create);
//    }
//
//    @Test
//    @Order(2)
//    void read() {
//        Admin read = adminService.read(admin.getAdminId());
//        assertNotNull(read);
//        System.out.println("Read: " + read);
//    }
//
//    @Test
//    @Order(3)
//    void update() {
//        Admin updated = new Admin.Builder().copy(admin)
//                .setName("Jane").build();
//        assertNotNull(adminService.update(updated));
//        System.out.println("Updated: " + updated);
//    }
//
//    @Test
//    @Order(4)
//    void delete() {
//        Admin deleted = adminService.delete(admin.getAdminId());
//        assertNotNull(deleted);
//        System.out.println("Deleted: " + deleted);
//    }
//
//    @Test
//    @Order(5)
//    void getAllUsers() {
//        System.out.println("Get All: ");
//        System.out.println(adminService.getAllUsers());
//    }
//}