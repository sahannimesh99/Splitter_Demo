package com.sahan.service.impl;

import com.sahan.dto.ReqDto;
import com.sahan.dto.ResDto;
import com.sahan.service.SplitterService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class SplitterServiceImpl implements SplitterService {
//    @Override
//    public ResDto convertInToArray(ReqDto reqDto) {
//        try {
//            String[] array = null;
//            if (reqDto.getSplitArray() != null) {
//                array = reqDto.getSplitArray().split("\\|");
//            }
//            ResDto resDto = new ResDto();
//            resDto.setStringArray(Arrays.asList(array));
//            System.out.println(Arrays.toString(array));
//            return resDto;
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException("Error while converting string to array");
//        }
//    }

    @Override
    public ResDto convertInToArray(ReqDto reqDto) {
        try {
            String[] array = null;
            String[] array1 = null;
            String[] array2 = null;
            if (reqDto.getSplitArray() != null) {
                String[] tempArray = reqDto.getSplitArray().split("\\|");
                if (tempArray.length >= 3) {
                    array = tempArray[0].trim().split("\\|");
                    array1 = tempArray[1].trim().split("\\|");
                    array2 = tempArray[2].trim().split("\\|");
                }
            }
            ResDto resDto = new ResDto();
            resDto.setStringArray(Arrays.asList(array));
            resDto.setStringArray1(Arrays.asList(array1));
            resDto.setStringArray2(Arrays.asList(array2));
            System.out.println(Arrays.toString(array));
            System.out.println(Arrays.toString(array1));
            System.out.println(Arrays.toString(array2));
            return resDto;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while converting string to array");
        }
    }
}
