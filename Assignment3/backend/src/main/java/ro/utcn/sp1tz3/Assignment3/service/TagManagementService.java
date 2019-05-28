package ro.utcn.sp1tz3.Assignment3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.utcn.sp1tz3.Assignment3.dto.TagDTO;
import ro.utcn.sp1tz3.Assignment3.entity.Tag;
import ro.utcn.sp1tz3.Assignment3.exception.TagNotFoundException;
import ro.utcn.sp1tz3.Assignment3.repository.TagRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TagManagementService {
    private final TagRepository repositoryFactory;

    @Transactional
    public List<TagDTO> listTags(){
        return repositoryFactory.findAll().stream().map(TagDTO::ofEntity).collect(Collectors.toList());
    }

    @Transactional
    public TagDTO addTag(TagDTO dto){
        Tag tag = new Tag();
        tag.setTitle(dto.getTitle());
        return TagDTO.ofEntity(repositoryFactory.save(tag));
    }

    @Transactional
    public void removeTag(int id){
        Tag tag = repositoryFactory.findById(id).orElseThrow(TagNotFoundException::new);
        repositoryFactory.delete(tag);
    }
}
