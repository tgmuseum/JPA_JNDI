package com.springapp.mvc;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA.
 * User: LSK
 * Date: 13. 8. 22
 * Time: 오후 5:09
 * To change this template use File | Settings | File Templates.
 */
public interface ComnRepository  extends JpaRepository<AccountEntity, Long> {
}
