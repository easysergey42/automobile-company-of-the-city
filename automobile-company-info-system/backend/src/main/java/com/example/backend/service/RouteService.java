package com.example.backend.service;

import com.example.backend.dto.RouteDTO;
import com.example.backend.entity.Route;
import com.example.backend.mappers.RouteMapper;
import com.example.backend.repository.RouteRepo;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RouteService {
    private final RouteRepo routeRepo;
    private final RouteMapper routeMapper;

    @Transactional
    public RouteDTO create(@NonNull RouteDTO routeDTO){
        routeDTO.setId(null);
        return routeMapper.toRouteDTO(routeRepo.save(routeMapper.toRoute(routeDTO)));
    }

    @Transactional
    public @NonNull RouteDTO getById(Long id) throws NoSuchElementException {
        return routeMapper.toRouteDTO(routeRepo.findById(id).orElseThrow());
    }

    @Transactional
    public @NonNull RouteDTO updateName(@NonNull RouteDTO routeDTO) throws NoSuchElementException{
        return routeMapper.toRouteDTO(routeRepo.save(routeMapper.toRoute(routeDTO)));
    }

    @Transactional
    public Long deleteById(Long id ){
        routeRepo.deleteById(id);
        return id;
    }

    @Transactional
    public List<RouteDTO> getAll(){
        return routeMapper.toDTOs(routeRepo.findAll());
    }

    public List<String> sendFields(){
        return Arrays.stream(RouteDTO.class.getDeclaredFields()).map(Field::getName).collect(Collectors.toList());
    }
}
