package net.guides.springboot2.crud.controller;

import java.util.List;
import javax.validation.Valid;
import net.guides.springboot2.crud.dto.UsuarioDto;
import net.guides.springboot2.crud.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.guides.springboot2.crud.projectionsDto.UsuarioView;
import net.guides.springboot2.crud.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

// https://www.vinaysahni.com/best-practices-for-a-pragmatic-restful-api
/*
    GET /usuarios?coEmpresa=1 - usuarios de la empresa 1
    GET /usuarios/1 - usuario con id 1
    POST /usuarios - crear un usuario
    PUT /usuarios/1 - modificacion global del usuario 1
    PATCH /usuarios/1 - modificacion parcial de usuario 1
    DELETE /usuarios/1 -  eliminar el usuario 1

FIXME:
puntos por realizar , agregar un uuid a la empresa para usar esa cadena en params

*/

@CrossOrigin(origins = "*", allowedHeaders = "GET,POST,PUT,PATCH,DELETE")
@RestController
@RequestMapping("/usuarios")
public class EmployeeController {
    
	@Autowired
        private UsuarioService usuarioService;
	         
	
        @GetMapping        	
	public ResponseEntity<List<UsuarioView>> getAllusuarios(@RequestParam(value = "coEmpresa") int coEmpresa) throws ResourceNotFoundException {                        
                System.out.println("@getAllEmployees ");
                try{
                    System.out.println("@Param "+coEmpresa);
                    
                    List<UsuarioView> lista = usuarioService.findByEliminado(coEmpresa);
                                   
                    return  new ResponseEntity<>(lista, HttpStatus.OK);
                
                }catch(Exception e){
                    e.printStackTrace();
                }
                return ResponseEntity.badRequest().body(null);
	}

	@GetMapping("/{id}")        
	public ResponseEntity<UsuarioView> getEmployeeById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
		
                final UsuarioView usuarioView = usuarioService.findById(id);		
                                       
		return ResponseEntity.ok().body(usuarioView);
	}

	@PostMapping
	public void createEmployee(@Valid @RequestBody UsuarioDto usuarioDto) {
            
                 System.out.println(" usuaro dto "+usuarioDto.toString());
		
                usuarioService.save(usuarioDto);
	}

/*	@PutMapping("/{id}")
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
