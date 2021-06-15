package com.gkhn.issuemanagement.api;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gkhn.issuemanagement.dto.IssueDto;
import com.gkhn.issuemanagement.service.impl.IssueServiceImpl;
import com.gkhn.issuemanagement.util.ApiPaths;


@RestController
@RequestMapping(path = ApiPaths.IssueCtrl.CTRL)
public class IssueController {

	private final IssueServiceImpl issueServiceImpl;

	public IssueController(IssueServiceImpl issueServiceImpl) {
		this.issueServiceImpl = issueServiceImpl;
	}

	@GetMapping("/{id}")
	public ResponseEntity<IssueDto> getById(@PathVariable("id") Long id) {
		IssueDto IssueDto = issueServiceImpl.getById(id);
		return ResponseEntity.ok(IssueDto);
	}

	@PostMapping()
	public ResponseEntity<IssueDto> createProject(@Valid @RequestBody IssueDto project) {
		return ResponseEntity.ok(issueServiceImpl.save(project));
	}

//	@RequestMapping(path = "/update",method = RequestMethod.PUT)
	@PutMapping("/{id}")
	public ResponseEntity<IssueDto> updateProject(@PathVariable("id") Long id,
			@Valid @RequestBody IssueDto project) {
		// SOLID'E TERS SAVE METODU İLE UPDATE YAPARSAK. TEK BİR FONKSİYONA HEM SAVE HEM
		// UPDATE YAPMAMALI
		return ResponseEntity.ok(issueServiceImpl.update(id, project));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable(value = "id") Long id) {
		return ResponseEntity.ok(issueServiceImpl.delete(id));
	}

}
