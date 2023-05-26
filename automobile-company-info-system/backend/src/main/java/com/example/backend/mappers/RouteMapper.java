package com.example.backend.mappers;

import com.example.backend.dto.RouteDTO;
import com.example.backend.entity.Route;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RouteMapper {
    RouteDTO toDTO(Route route);

    List<RouteDTO> toDTOs(List<Route> routes);

    Route toRoute(RouteDTO routeDTO);
    List<Route> toRoutes(List<RouteDTO> routes);
}
