package com.kos.cafe.valid;

import com.kos.cafe.domain.NewsDTO;

/**
 * Created by Hrytsuk.K.O on 12.02.2016.
 */
public class NewsValidator {


    public static String valid(NewsDTO dto){
        StringBuilder builder = new StringBuilder();
        builder.append("");
        if (dto.getSubject().length()<1){builder.append("Subjec must be present|");}
        if (dto.getText().length()<1){builder.append("Text of the news must be present");}
        return builder.toString();
    }
}
