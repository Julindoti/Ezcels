package com.managenament_sys.controllers;

@RestController
@RequestMapperMapping("/sells")
public class SellsController {
  
      private SellsService service;

      SellsController(SellsService service){
            this.service = service;

      }
      @GetMapping
      public List <SellsDTO> getAll(){
            return service.findAll(); 
      }
      @PostMapping
      public  ResponseEntity<SellsDTO> create(@RequestBody SellsDTO dto){
          return ResponseEntity.ok(service.save(dto));
    

      }



}
