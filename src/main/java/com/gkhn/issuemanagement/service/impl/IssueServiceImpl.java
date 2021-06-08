package com.gkhn.issuemanagement.service.impl;

import com.gkhn.issuemanagement.dto.IssueDto;
import com.gkhn.issuemanagement.entity.Issue;
import com.gkhn.issuemanagement.repository.IssueRepository;
import com.gkhn.issuemanagement.service.IssueService;
import com.gkhn.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Arrays;

@Service
public class IssueServiceImpl implements IssueService {

    /*
    @Autowired
    private IssueRepository issueRepository;   Autowired önerilmiyor. Constructor kullanılması best-practice. Çünkü final ile işaretlersek, sadece constructor içinde değer atayabiliyoruz. Böylece güvenliği sağlıyoruz.
*/
    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;

    public IssueServiceImpl(IssueRepository issueRepository, ModelMapper modelMapper) {  //Inject etmiş olduk....
        this.issueRepository = issueRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public IssueDto save( IssueDto issueDto) {
        if(issueDto.getDate()==null)
            throw new IllegalArgumentException("Issue Date cannot be null");
        Issue issueDb = modelMapper.map(issueDto, Issue.class);
        issueDb  = issueRepository.save(issueDb);
        return modelMapper.map(issueDb,IssueDto.class);
    }

    @Override
    public IssueDto getById(Long id) {
        return null;
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable pageable) {
        Page<Issue> data =issueRepository.findAll(pageable);
        TPage<IssueDto> page = new TPage<IssueDto>();
        IssueDto[] dtos = modelMapper.map(data.getContent(),IssueDto[].class);
        page.setStat(data,Arrays.asList(dtos));
        return page;
    }

    @Override
    public Boolean delete(IssueDto issue) {
        return null;
    }
}
