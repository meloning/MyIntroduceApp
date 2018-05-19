package com.example.junsu.androidproject.error;

import com.example.junsu.androidproject.vo.curvegraph.CurveGraphVO;

public class ErrorDetector {
	public static ErrorCode checkGraphObject(CurveGraphVO curveGraphVO){
		//1. vo check
		if(curveGraphVO == null){
			return ErrorCode.GRAPH_VO_IS_EMPTY;
		}
		
		//2. legend and graph size check
		int legendSize = curveGraphVO.getLegendArr().length;
		for (int i = 0; i < curveGraphVO.getArrGraph().size(); i++) {
			if(legendSize !=curveGraphVO.getArrGraph().get(i).getCoordinateArr().length){
				return ErrorCode.INVALIDATE_GRAPH_AND_LEGEND_SIZE;
			}
		}
		
		return ErrorCode.NOT_ERROR;
	}
	
	public static ErrorCode checkLineCompareGraphObject(CurveGraphVO curveGraphVO){
		//1. vo check
		if(curveGraphVO == null){
			return ErrorCode.GRAPH_VO_IS_EMPTY;
		}

		
		//2 graph size must be 2
		if(curveGraphVO.getArrGraph().size() != 2){
			return ErrorCode.LINE_COMPARE_GRAPH_SIZE_MUST_BE_2;
		}
				
		//3. legend and graph size check
		int legendSize = curveGraphVO.getLegendArr().length;
		for (int i = 0; i < curveGraphVO.getArrGraph().size(); i++) {
			if(legendSize !=curveGraphVO.getArrGraph().get(i).getCoordinateArr().length){
				return ErrorCode.INVALIDATE_GRAPH_AND_LEGEND_SIZE;
			}
		}
		
		return ErrorCode.NOT_ERROR;
	}
	

}
