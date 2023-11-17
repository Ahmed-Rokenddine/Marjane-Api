package controller;

import java.util.List;

import Entity.AdminEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import service.AbstractService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class AdminController  {
    @Qualifier("adminServiceImp")
    @Autowired
    private AbstractService adminService;

    /*---Add new admin---*/
    @PostMapping("/admin")
    public ResponseEntity<?> save(@RequestBody AdminEntity admin) {
        int id = adminService.save(admin);
        return ResponseEntity.ok().body("New admin has been saved with ID:" + id);
    }

    @GetMapping("/admin/{id}")
    public ResponseEntity<AdminEntity> get(@PathVariable("id") int id) {
        AdminEntity admin = (AdminEntity) adminService.get(id);
        if (admin == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(admin);
    }

    /*---get all admins---*/
    @GetMapping("/admin")
    public ResponseEntity<List<AdminEntity>> list() {
        List<AdminEntity> admins = adminService.list();
        return ResponseEntity.ok().body(admins);
    }

    /*---Update a admin by id---*/
    @PutMapping("/admin/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody AdminEntity admin) {
        adminService.update(id, admin);
        return ResponseEntity.ok().body("admin has been updated successfully.");
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        adminService.delete(id);
        return ResponseEntity.ok().body("admin has been deleted successfully.");
    }
}
