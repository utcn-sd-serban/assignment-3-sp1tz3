package ro.utcn.sp1tz3.Assignment3.dto;

import lombok.Data;
import ro.utcn.sp1tz3.Assignment3.entity.Tag;

@Data
public class TagDTO {
    private String title;

    public static TagDTO ofEntity(Tag tag){
        TagDTO dto = new TagDTO();
        dto.setTitle(tag.getTitle());
        return dto;
    }
}
