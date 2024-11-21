package com.pets.web.controller;

import com.pets.domain.dto.PetDTO;
import com.pets.domain.service.PetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pets")
@CrossOrigin(origins = "http://localhost:4200")

public class PetController {

    @Autowired
    private PetService petService;

    @Operation(summary = "Obtener todas las mascotas", description = "Retorna una lista de todas las mascotas registradas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de mascotas obtenida exitosamente"),
            @ApiResponse(responseCode = "204", description = "No hay mascotas registradas"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/all")
    public ResponseEntity<List<PetDTO>> getAll() {
        List<PetDTO> pets = petService.getAllPets();
        if (pets.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    @Operation(summary = "Obtener una mascota por ID", description = "Retorna una mascota específica según el ID proporcionado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mascota encontrada"),
            @ApiResponse(responseCode = "404", description = "Mascota no encontrada"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/{id}")
    public ResponseEntity<PetDTO> getPet(@PathVariable("id") int petId) {
        Optional<PetDTO> pet = petService.getPetById(petId);
        return pet.map(petDTO
                -> new ResponseEntity<>(petDTO, HttpStatus.OK)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Guardar una mascota", description = "Registra una nueva mascota en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Mascota registrada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PostMapping("/save")
    public ResponseEntity<PetDTO> save(@Valid @RequestBody PetDTO petDTO) {
        PetDTO savedPet = petService.savePet(petDTO);
        return new ResponseEntity<>(savedPet, HttpStatus.CREATED);
    }

    @Operation(summary = "Editar una mascota", description = "Actualiza los datos de una mascota existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mascota actualizada exitosamente"),
            @ApiResponse(responseCode = "404", description = "Mascota no encontrada"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PutMapping("/edit/{id}")
    public ResponseEntity<PetDTO> edit(@PathVariable("id") int petId, @Valid @RequestBody PetDTO petDTO) {
        Optional<PetDTO> existingPet = petService.getPetById(petId);
        if (existingPet.isPresent()) {
            petDTO.setId(petId);
            PetDTO updatedPet = petService.savePet(petDTO);
            return new ResponseEntity<>(updatedPet, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Eliminar una mascota", description = "Elimina una mascota específica según el ID proporcionado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Mascota eliminada exitosamente"),
            @ApiResponse(responseCode = "404", description = "Mascota no encontrada"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int petId) {
        boolean deleted = petService.deletePet(petId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
