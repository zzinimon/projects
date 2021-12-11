package com.example.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.myapp.entity.AlphaServiceVO;
import com.example.myapp.entity.BasicServiceVO;
import com.example.myapp.entity.StationVO;
import com.example.myapp.service.AlphaServiceService;
import com.example.myapp.service.BasicServiceService;
import com.example.myapp.service.LineService;
import com.example.myapp.service.StationService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

@Controller
@RequestMapping("data")		//관리자페이지에 구현예정인 것들 
public class SubDataController {

	@Autowired
	StationService stationService;
	
	@Autowired
	BasicServiceService basicServiceService;
	
	@Autowired
	AlphaServiceService alphaServiceService;
	
	@Autowired
	LineService lineService;
	
	@GetMapping("/update")	//DB 업데이트 페이지로 이동
	public String dataUpdateGet(Model model) {
		//System.out.println(stationService.findAll());
		model.addAttribute("sList", stationService.findAll());
		return "subData";
	}
	
	@GetMapping("/detail")
	public String dataDetailGet(Model model, @RequestParam Long stId) {
		StationVO vo = stationService.findById(stId);
		model.addAttribute("detail", vo);
		return "detail";
	}

	@ResponseBody
	@PostMapping("/update")	//DB 업데이트를 수행
	public String dataUpdatePost(String str){
		JSONObject jObject;
		try {
			jObject = new JSONObject(str);
			JSONObject resultObj = jObject.getJSONObject("result");
			
			String stationName = resultObj.getString("stationName");
			Long stationID = Long.parseLong(resultObj.getString("stationID"));		//table : station
			//System.out.println(stationID);
			
			Integer type = Integer.parseInt(resultObj.getString("type"));	//line_id
			String laneName = resultObj.getString("laneName");			//table : station
			//System.out.println("stationName: " + stationName);
			// System.out.println("type: " + type);
			//System.out.println("laneName: " + laneName);
			
			//JSONArray stationArr = resultObj.getJSONObject("nextOBJ").getJSONArray("station");
			/*
			 * for (int i = 0; i < stationArr.length(); i++) { JSONObject obj =
			 * stationArr.getJSONObject(i); String n_stationName =
			 * obj.getString("stationName"); //table : station //
			 * System.out.println(n_stationName); }
			 */
			
			JSONObject defaultInfo = resultObj.getJSONObject("defaultInfo");
			String address = defaultInfo.getString("address");			//table : station
			String tel = defaultInfo.getString("tel");					//table : station
			
			JSONObject useInfo = resultObj.getJSONObject("useInfo");
			
				//basic_service
			int restroom = useInfo.getInt("restroom");
			int offDoor = useInfo.getInt("offDoor");
			int crossOver = useInfo.getInt("crossOver");
			int publicPlace = useInfo.getInt("publicPlace");
			int parkingCount = useInfo.getInt("parkingCount");
			int civilCount = useInfo.getInt("civilCount");

				//alpha_service
			int bicycleCount = useInfo.getInt("bicycleCount");
			int meetingPlace = useInfo.getInt("meetingPlace");
			int handicapCount = useInfo.getInt("handicapCount");
			int platform = useInfo.getInt("platform");
			
			if (stationID!=null) {
				StationVO oriVO = stationService.findById(stationID);
				if (oriVO!=null) {						//가져온 데이터에 중복값이 존재한다면
					BasicServiceVO oriBSvo = oriVO.getBService();
					AlphaServiceVO oriASvo = oriVO.getAService();
					oriBSvo = BasicServiceVO.builder()
							.id(oriBSvo.getId())
							.restroom(restroom)
							.offDoor(offDoor)
							.crossOver(crossOver)
							.publicPlace(publicPlace)
							.parkingCount(parkingCount)
							.civilCount(civilCount)
							.build();
					oriASvo = AlphaServiceVO.builder()
							.id(oriASvo.getId())
							.bicycleCount(bicycleCount)
							.meetingPlace(meetingPlace)
							.handicapCount(handicapCount)
							.build();
					oriVO = StationVO.builder()
							.id(oriVO.getId())			//기존의 id를 가지고 있는 객체로 저장
							.laneName(laneName)
							.tel(tel)
							.stationName(stationName)
							.address(address)
							.line(lineService.findById(type))
							.build();
					oriBSvo.setStation(oriVO);
					oriASvo.setStation(oriVO);
					oriVO.setBService(oriBSvo);
					oriVO.setAService(oriASvo);
					if (!defaultInfo.isNull("new_address")) {	//new_address 는 nullable 항목임
						String newAddress = defaultInfo.getString("new_address");	//table : station
						oriVO.setNewAddress(newAddress);
					}
					stationService.save(oriVO);
				} else {
					BasicServiceVO newBSvo = BasicServiceVO.builder()
							.restroom(restroom)
							.offDoor(offDoor)
							.crossOver(crossOver)
							.publicPlace(publicPlace)
							.parkingCount(parkingCount)
							.civilCount(civilCount)
							.build();
					AlphaServiceVO newASvo = AlphaServiceVO.builder()
							.bicycleCount(bicycleCount)
							.meetingPlace(meetingPlace)
							.handicapCount(handicapCount)
							.build();
					StationVO newVO = StationVO.builder()	//아니면 새로운 객체로 저장
							.id(stationID)
							.laneName(laneName)
							.tel(tel)
							.stationName(stationName)
							.address(address)
							.line(lineService.findById(type))
							.build();
					newBSvo.setStation(newVO);
					newASvo.setStation(newVO);
					newVO.setBService(newBSvo);
					newVO.setAService(newASvo);
					if (!defaultInfo.isNull("new_address")) {	//new_address 는 nullable 항목임
						String newAddress = defaultInfo.getString("new_address");	//table : station
						newVO.setNewAddress(newAddress);
					}
					stationService.save(newVO);
				}
			}
		} catch (JSONException e) {
			//e.printStackTrace();
			System.out.println("--- 데이터없음 ---");
		}

		return "redirect:/subData";
	}

}
