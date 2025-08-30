//package za.ac.cput.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import za.ac.cput.domain.Admin;
//import za.ac.cput.repository.AdminRepository;
//
//import java.util.List;
//
//@Service
//public class AdminService implements IAdmin {
//   private final AdminRepository adminRepository;
//
//   @Autowired
//    public AdminService(AdminRepository adminRepository) {
//          this.adminRepository = adminRepository;
//     }
//
//
//    @Override
//    public Admin create(Admin admin) {
//        if (adminRepository.findbyAdminEmail(admin.getEmail()) != null) {
//            throw new RuntimeException("admin email already exists");
//        }
//        return adminRepository.save(admin);
//    }
//
//    @Override
//    public Admin read(Long aLong) {
//        if (adminRepository.findbyAdminEmail(aLong.toString()) == null) {
//            throw new RuntimeException("admin email does not exist");
//        }
//        return adminRepository.findbyAdminEmail(aLong.toString());
//    }
//
//    @Override
//    public Admin update(Admin admin) {
//        if (adminRepository.findbyAdminEmail(admin.getEmail()) == null) {
//            throw new RuntimeException("admin email does not exist");
//        }
//        return adminRepository.save(admin);
//    }
//
//    @Override
//    public Admin delete(Long aLong) {
//        Admin admin = adminRepository.findbyAdminEmail(aLong.toString());
//        if (admin == null) {
//            throw new RuntimeException("admin email does not exist");
//        }
//        adminRepository.delete(admin);
//        return admin;
//    }
//
//    @Override
//    public List<Admin> getAllUsers() {
//        return List.of();
//    }
//}
