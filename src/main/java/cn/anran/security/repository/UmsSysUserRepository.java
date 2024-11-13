package cn.anran.security.repository;

import cn.anran.security.Domain.dao.UmsSysUser;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author: KaelviHN
 * @created: 2024/11/12
 * @description:
 **/
@Repository
public interface UmsSysUserRepository extends BaseRepository<UmsSysUser, Long>{
    Optional<UmsSysUser> findByUsername(String username);
}
