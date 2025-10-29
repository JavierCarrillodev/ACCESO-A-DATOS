package cursoSpringboot.controllers;

import cursoSpringboot.domain.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@RestController
@RequestMapping("/clientes")

public class CustomerController {

    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(1,"Javi","Javimega14","1234"),
            new Customer(2,"Victoria","Vimoji","1309"),
            new Customer(3,"Tati","tati123","1122"),
            new Customer(4,"Fifi","fifita123","2233")
    ));

//    @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers(){

        return ResponseEntity.ok(customers);
//        return customers;
    }


//    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    @GetMapping("/{username}")
    public ResponseEntity<?> getCliente (@PathVariable String username){
        for (Customer cliente:customers){
            if (cliente.getUsername().equalsIgnoreCase(username)){

                return ResponseEntity.ok(cliente);
            }

        }
        return ResponseEntity.notFound().build();
    }

//    @RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public ResponseEntity<?> postCliente(@RequestBody Customer customer){
        for (Customer cliente:customers){
            if (cliente.getID() == customer.getID()){
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Este id ya esta siendo usado");
            }
        }
        customers.add(customer);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{username}")
                .buildAndExpand(customer.getUsername())
                .toUri();

//        return ResponseEntity.created(location).build();
        return ResponseEntity.created(location).body(customer);
    }

//    @RequestMapping(method = RequestMethod.PUT)
    @PutMapping
    public ResponseEntity<?> putCliente(@RequestBody Customer customer){
        for (Customer cliente:customers){
            if (cliente.getID() == customer.getID()){
                cliente.setName(customer.getName());
                cliente.setUsername(customer.getUsername());
                cliente.setPassword(customer.getPassword());

                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

//    @RequestMapping( value = "/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable int id){
        for (Customer cliente:customers){
            if (cliente.getID() == id){
                customers.remove(cliente);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El cliente no existe: " + id);
    }

//    @RequestMapping(method = RequestMethod.PATCH)
    @PatchMapping
    public ResponseEntity<?> patchCliente(@RequestBody Customer customer){
        for (Customer cliente:customers){
            if (cliente.getID() == customer.getID()){
                if (customer.getName() !=null){
                    cliente.setName(customer.getName());
                }
                if (customer.getUsername() !=null){
                    cliente.setUsername(customer.getUsername());
                }
                if (customer.getPassword() !=null){
                    cliente.setPassword(customer.getPassword());
                }
                return ResponseEntity.ok("Cliente actualizado satisfactoriamente: " + customer.getID());
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado: "  + customer.getID());
    }









}
