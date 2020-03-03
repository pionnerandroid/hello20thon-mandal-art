package com.hnu.pioneer.controller;

import com.hnu.pioneer.Dto.MemberSaveRequestDto;
import com.hnu.pioneer.Dto.StudySaveRequestDto;
import com.hnu.pioneer.service.MemberService;
import com.hnu.pioneer.service.StudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@org.springframework.web.bind.annotation.RestController
public class RestController {

    private final MemberService memberService;
    private final StudyService studyService;

    @PostMapping("/signup/request")
    public Long signUpRequest(
            @RequestBody MemberSaveRequestDto requestDto, Model model) {
        return memberService.signUp(requestDto);
    }

    @PostMapping("/create-study/save")
    public Long saveStudy(@RequestBody StudySaveRequestDto requestDto) {
        System.out.println("OKOKOKOK");;
        return studyService.save(requestDto);
    }

    @GetMapping("/study/apply")
    public Long applyStudy() {
        return 1L;
    }
}
