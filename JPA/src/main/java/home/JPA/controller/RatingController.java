package home.JPA.controller;

import home.JPA.dto.MemberRatingDto;
import home.JPA.dto.UnivRatingDto;
import home.JPA.entity.UnivRating;
import home.JPA.service.MemberService;
import home.JPA.service.impl.UnivService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rating")
@AllArgsConstructor
public class RatingController {
    private final UnivService univService;
    private final MemberService memberService;
    @GetMapping("/univ")
    public ResponseEntity<List<UnivRatingDto>> getUnivRatingList(){
        return ResponseEntity.ok(univService.getUnivRating());
    }
    @GetMapping("/member")
    public ResponseEntity<List<MemberRatingDto>> getMemberRatingList(){
        return ResponseEntity.ok(memberService.getMemberRating());
    }
    @GetMapping("/private-univ")
    public ResponseEntity<List<UnivRatingDto>>getPrivateUnivRatingList(@RequestParam String univName){
        return ResponseEntity.ok(univService.getPrivateRating(univName));
    }
    @GetMapping("/private-member")
    public ResponseEntity<List<MemberRatingDto>> getPrivateMemberRatingList(@RequestParam String nickName){
        return ResponseEntity.ok(memberService.getPrivateMemberRating(nickName));
    }
}
