package com.example.demo.security

import com.example.demo.model.User
import com.example.demo.repository.UserRepo
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component
import javax.inject.Inject

/**
 * Created by divine on 2017/06/08.
 */
@Component
open class QuickPollUserDetailService : UserDetailsService {

    @Inject
    lateinit var userRepo: UserRepo

    override fun loadUserByUsername(username: String): UserDetails {
        val user: User
                = userRepo.findByUsername(username)
                ?: throw UsernameNotFoundException("user with username: $username not found Exception")

        val authorities: List<GrantedAuthority> = emptyList()
        if(user.admin) AuthorityUtils.createAuthorityList("ROLE_ADMIN")
        val userDetails: UserDetails = org.springframework.security.core.userdetails.User(user.username, user.password, authorities)

        return  userDetails
    }
}
