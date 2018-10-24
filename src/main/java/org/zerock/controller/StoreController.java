package org.zerock.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.StoreVO;
import org.zerock.service.StoreService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController //5.0.1로 바꾸기
@RequestMapping("/store/*")
@Log4j
@AllArgsConstructor //주입하기
public class StoreController {
	
	//주입하기
	private StoreService service;
	
	@GetMapping("/{idx}") //'{'이용시 파라미터 수집
	public StoreVO get(@PathVariable("idx") int idx) {
		
		return service.get(idx);
	}
	
	@DeleteMapping("/{idx}") //408p
	public String remove(@PathVariable("idx") int idx) {
		
		log.info("remove........................." + idx);
		service.remove(idx);
		
		return "success";
	}
	
	
	
	
	
	
	@PostMapping("/new")
	public String add(@RequestBody StoreVO vo) { //requestbody: 제이슨 데이터를 자바의 객체로 변환해주는 역할.
		
		//로그포 제이 추가 후
		log.info("----------------");
		log.info(vo);
		
		
		return "success";
	}//제이슨을 객체로 바꾸기 위한 것.
	
	@CrossOrigin(origins="*") //웹스톰과 연결 주고받기
	@GetMapping("/sample")
	public StoreVO get() {
		
		StoreVO vo = new StoreVO();
		vo.setSno(1);
		vo.setSname("김밥천국");
		vo.setLat(37.123);
		vo.setLng(123.4567);
		
		return vo;
		
	}

}
