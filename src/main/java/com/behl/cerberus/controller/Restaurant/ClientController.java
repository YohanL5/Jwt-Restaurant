package com.behl.cerberus.controller.Restaurant;
import com.behl.cerberus.configuration.PublicEndpoint;
import com.behl.cerberus.dto.Restaurant.ClientDTO;
import com.behl.cerberus.dto.Restaurant.errorDto.ClientErrorDTO;
import com.behl.cerberus.service.Restaurant.clients.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;


    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    @Operation(summary = "Creates a client", description = "Register a client in the system to place orders with the restaurant")
    @ApiResponses(value={
            @ApiResponse(responseCode = "201",description = "Client created successfully")
    })
    public ResponseEntity<?> createClient(@RequestBody ClientDTO clientDTO) {
        clientService.createClient(clientDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientDTO);
//            ClientErrorDTO clientErrorDTO = new ClientErrorDTO();
//            clientErrorDTO.setMessage(e.getMessage());
//            return ResponseEntity
//                    .status(HttpStatus.BAD_REQUEST)
//                    .body(clientErrorDTO.getMessage());
//
    }
    @GetMapping("/")
    @Operation(summary = "Get a clients", description = "List restaurant customers")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200",description = "List Clients successfully")
    })
    @PreAuthorize("hasAuthority('fullaccess')")
    public ResponseEntity<?> getClients() {

        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.clientService.getClients());
        } catch (Exception e) {
            ClientErrorDTO clientErrorDTO = new ClientErrorDTO();
            clientErrorDTO.setMessage(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(clientErrorDTO.getMessage());
        }
    }

    @GetMapping("/{document}")
    @Operation(summary = "Get a client", description = "Registered Client at the restaurant")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200",description = "Client successfully")
    })
    @PreAuthorize("hasAuthority('fullaccess')")
    public ResponseEntity<?>getClient( @PathVariable String document){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.clientService.getClient(document));
        } catch (Exception e) {
            ClientErrorDTO clientErrorDTO = new ClientErrorDTO();
            clientErrorDTO.setMessage(e.getMessage());
            return  ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(clientErrorDTO.getMessage());
        }
    }


    @PutMapping("/{document}")
    @Operation(summary = "Update a client", description = "update client data")
    @ApiResponses(value={
            @ApiResponse(responseCode = "202",description = "update Client successfully")
    })
    @PreAuthorize("hasAuthority('fullaccess')")
    public ResponseEntity<?>UpdateClient(@PathVariable String document, @RequestBody ClientDTO clientDTO) {
        try {
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(this.clientService.updateClient(document, clientDTO));
        } catch (Exception e) {
            ClientErrorDTO clientErrorDTO = new ClientErrorDTO();
            clientErrorDTO.setMessage(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(clientErrorDTO.getMessage());
        }
    }
    @DeleteMapping("/{document}")
    @Operation(summary = "Delete a client", description = "Delete clients of the restaurant")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200",description = "List Clients successfully")
    })
    @PreAuthorize("hasAuthority('fullaccess')")
    public void deleteClient(@PathVariable String document){
        clientService.deleteClient(document);
    }



}