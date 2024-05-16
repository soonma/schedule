package org.sparta.schedule.controller;

import org.sparta.schedule.dto.ScheduleRequestDto;
import org.sparta.schedule.dto.ScheduleResponseDto;
import org.sparta.schedule.service.ScheduleService;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api")
public class ScheduleController {
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/login")
    public Long login(@RequestBody Long id, @RequestBody String passwd){
        return scheduleService.getLogin(id, passwd);
    }

    @PostMapping("/write")//클라이언트의 요청 데이터(Request Body)를 서버에 생성할 때 사용
    public ScheduleResponseDto create(@RequestBody ScheduleRequestDto requestDto) {
        return scheduleService.createSchedule(requestDto);
    }

    @GetMapping("/selectAll")//요청받은 URL 정보를 검색하여 응답한다
    public List<ScheduleResponseDto> getSchedule() {
        return scheduleService.getSchedule();
    }

    @GetMapping("/selectDetail/{id}")//요청받은 URL 정보를 검색하여 응답한다
    public ScheduleResponseDto getDetailSchedule(@PathVariable Long id) {
        return scheduleService.getDetailSchedule(id);
    }

    @PutMapping("/edit/{id}/passwd/{passwd}") //요청된 자원을 수정한다.
    public Long updateSchedule(@PathVariable Long id,@PathVariable String passwd, @RequestBody ScheduleRequestDto requestDto) {
        return scheduleService.updateSchedule(id,passwd,requestDto);
    }

    @DeleteMapping("/memos/{id}") //요청된 자원을 삭제 할때 사용
    public String deleteSchedule(@RequestParam(required = false) String title, String passwd) {
        return scheduleService.deleteMemo(title,passwd);
    }

}
