/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tw.whalebox.blogweb;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author hsean
 */

public interface PostRepository extends JpaRepository<Post, Long>{
    @Override
    List<Post> findAll();
    List<Post> findById(long Id);
}
