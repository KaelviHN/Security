package cn.anran.security.repository;

import cn.anran.security.Domain.dao.UmsMenu;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @author: KaelviHN
 * @created: 2024/11/13
 * @description:
 **/
@Repository
public interface UmsMenuRepository extends BaseRepository<UmsMenu, Long>{
    Set<UmsMenu> findByIdIn(Set<Long> ids);
}
