package edu.miu.lelafoods.auth.controller;

import edu.miu.lelafoods.auth.domain.AuthenticationRequest;
import edu.miu.lelafoods.auth.domain.AuthenticationResponse;
import edu.miu.lelafoods.auth.domain.User;
import edu.miu.lelafoods.auth.service.MyUserDetailsService;
import edu.miu.lelafoods.auth.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.ok;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        final User user = userDetailsService.getByUsername(authenticationRequest.getUsername());
        final List<String> roles = user.getRoles();
        final String jwt = jwtTokenUtil.generateToken(userDetails,roles);
        final String name = user.getFirstName() + (user.getMiddleName() != null ? " " + user.getMiddleName(): "") + " " + user.getLastName();
        return ok(new AuthenticationResponse(jwt,userDetails.getUsername(),name,roles));
    }

    @GetMapping("/me")
    public ResponseEntity currentUser(@AuthenticationPrincipal UserDetails userDetails){
        Map<Object, Object> model = new HashMap<>();
        model.put("username", userDetails.getUsername());
        model.put("user", userDetailsService.getByUsername(userDetails.getUsername()));
        model.put("roles", userDetails.getAuthorities()
                .stream()
                .map(a -> ((GrantedAuthority) a).getAuthority())
                .collect(toList())
        );
        return ok(model);
    }

}
