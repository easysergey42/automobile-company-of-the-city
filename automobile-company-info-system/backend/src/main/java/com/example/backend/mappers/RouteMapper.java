package com.example.backend.mappers;


import com.example.backend.dto.RouteDTO;
import com.example.backend.entity.Route;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses={BusMapper.class, RouteTaxiMapper.class})
public interface RouteMapper {

    RouteDTO toRouteDTO(Route route);

    List<RouteDTO> toDTOs(List<Route> routes);

    Route toRoute(RouteDTO routeDTO);
}
