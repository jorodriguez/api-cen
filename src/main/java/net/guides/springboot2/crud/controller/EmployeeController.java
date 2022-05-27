package net.guides.springboot2.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.guides.springboot2.crud.model.Usuario;
import net.guides.springboot2.crud.repository.impl.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", allowedHeaders = "GET,POST,PUT,PATCH,DELETE")
@RestController
@RequestMapping("/usuarios")
public class EmployeeController {
	@Autowired
	private UsuarioRepository usuarioRepository;

         
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
        //@RequestMapping(value = "/login", method = RequestMethod.POST)        
	public ResponseEntity<List<Usuario>> getAllEmployees() {
                System.out.println("@getAllEmployees ");
                try{
                       
                    List<Usuario> lista = usuarioRepository.getUsuarios();
                                   
                    return  new ResponseEntity<>(lista, HttpStatus.OK);
                
                }catch(Exception e){
                    e.printStackTrace();
                }
                return ResponseEntity.badRequest().body(null);
	}

/*	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Usuario employee = usuarioRepository.find(employeeId);
				//.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(employee);
	}

	@PostMapping("/")
	public Usuario createEmployee(@Valid @RequestBody Usuario employee) {
		//return usuarioRepository.save(employee);
                return usuarioRepository.create(employee, 1);
	}

	@PutMapping("/{id}")
	public ResponseEntity updateEmployee(@PathVariable(value = "id") Long employeeId,
			@Valid @RequestBody Usuario employeeDetails) throws ResourceNotFoundException {
		Usuario employee = usuarioRepository.find(employeeId);
//				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		
                
		//final Usuario updatedEmployee = usuarioRepository.save(employee);
                usuarioRepository.edit(employee,1);
                
		return ResponseEntity.status(200).body("ok");
	}

	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Usuario employee = usuarioRepository.find(employeeId);
				//.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		usuarioRepository.remove(employee,1);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}*/
}
