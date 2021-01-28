package com.wmp.project.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import org.springframework.stereotype.Service;

@Service
public class WmpService {
	
	/**
	 * @Method: 정규식을 적용한 값 반환
	 * @param str: 정규식을 적용하려는 문자열
	 * @param pattern: 정규식
	 */
	public String[] setPattern(String str, String pattern) {
		return str.replaceAll(pattern,"").trim().split("");
	}
	
	/**
	 * @Method: 정렬
	 * @param arr: 정렬하려는 문자배열
	 * @param ascendingOrder: true 오름차순, false 내림차순
	 */
	public PriorityQueue<String> lineUpStr(String[] arr, boolean ascendingOrder) {
		PriorityQueue<String> pq = ascendingOrder == true ? new PriorityQueue<>() : new PriorityQueue<>(Collections.reverseOrder());
		for (String s : arr) {
			pq.add(s);
		}
		
		return pq;
	}
	
	/**
	 * @Method: 입력받은 두개의 값을 교차 배치 후 반환
	 * @param: PriorityQueue for 영문자, 숫자
	 */
	public String mixStr(PriorityQueue<String> pqEng, PriorityQueue<String> pqNum) {
		String unionStr = "";
		while (true) {
			unionStr += pqEng.peek() != null ? pqEng.poll() : "";
			unionStr += pqNum.peek() != null ? pqNum.poll() : "";

			if (pqEng.size() < 1 && pqNum.size() < 1) {
				break;
			}
		}

		return unionStr;
	}
	
	/**
	 * @Method: 문자열 나눗셈
	 * @param unit: 문자열을 나눌 단위
	 */
	public Map<String, Object> divideStr(String unionStr, int unit) {
		int quotient = unionStr.length() / unit;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("quotient", unionStr.substring(0, quotient));
		map.put("remainder", unionStr.substring(quotient));
		return map;
	}

}
