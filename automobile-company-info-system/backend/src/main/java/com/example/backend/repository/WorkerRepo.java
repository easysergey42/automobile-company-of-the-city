package com.example.backend.repository;

import com.example.backend.entity.Worker;
import com.example.backend.repository.interfaces.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface WorkerRepo extends CrudRepository<Worker, Long> {

    @Query(
            value = "Select spec , person_id as personId, team_id as teamId from Worker where id = :#{#id}", nativeQuery = true
    )
    List<TestWorker> oleg(@Param("id") Long id);

    ///             2
    @Query(
            value = """
                        select w.id as id, first_name|| ' ' || last_name as name
                        from worker w join person p on w.person_id = p.id
                        join vehicledriver v on v.driver_id = w.id
                        where w.spec = 'driver' and v.vehicle_id = :#{#vehicleId}
                    """,
            nativeQuery = true
    )
    List<DriversPerVehicle> getSecondQuery(@Param("vehicleId") Long vehicleId);

    ///   3
    @Query(
            value = """
                       select v.id, v.model, v.number, count (vd.vehicle_id) as numberOfDrivers 
                       
                       from vehicle v
                       left join vehicledriver vd on vd.vehicle_id = v.id
                       group by v.id
                       order by count(vd.vehicle_id) desc, v.id
                    """,
            nativeQuery = true
    )
    List<Query3> getThirdQuery();

    ///     4
    @Query(
            value = """
                        select r.route_name as routeName, count(*) as numberOfVehicles
                        from route r
                        left join bus b on b.route = r.route_id
                        left join route_taxi rt on rt.route = r.route_id
                        group by r.route_id
                        order by count(*) desc
                    """,
            nativeQuery = true
    )
    List<Query4> getFourthQuery();

    ///     6
    @Query(
            value = """
                        select v.number, v.model, count(*), sum(r.repair_price)
                        from passenger_car pc --Категория легковой транспорт
                        left join vehicle v on v.id = pc.vehicle_id
                        left join repair r on r.vehicle_id = pc.vehicle_id
                        group by v.id
                    """,
            nativeQuery = true
    )
    List<Query6> getSixthQuery();

    ///     9

    @Query(value = """
                        select "buses".quantity as numberOfBuses,
                        "Taxis".quantity as numberOfTaxiCars,
                        "Route taxis".quantity as numberOfRouteTaxiCars,
                        "Trucks".quantity as numberOfTrucks,
                        "Passenger cars".quantity as numberOfPassengerCars,
                        "Specials".quantity as numberOfSpecialTransport
                        from (select count(*) as quantity from bus b ) "buses",
                        (select count(*) as quantity from taxi t) "Taxis",
                        (select count(*) as quantity from route_taxi rt) "Route taxis",
                        (select count(*) as quantity from truck t2) "Trucks",
                        (select count(*) as quantity from passenger_car pc) "Passenger cars",
                        (select count(*) as quantity from special_equipment_vehicle sev) "Specials"
                   """,
            nativeQuery = true
    )
    List<Query9> get9Query();

    ///     12
    @Query(value = """
                        select v.id, v.acquire_date as acquireDate, v.mileage, v.model, v.number, v.write_off_date as writeOffDate
                        from vehicle v
                        where v.acquire_date between
                        ?1 and ?2
                        or v.write_off_date between
                        ?1 and ?2
                        
                   """,
            nativeQuery = true
    )
    List<Query12> get12Query( Date first,
                              Date second);

    ///     15

    @Query(value = """
                        select p.first_name || ' ' || p.last_name as name, w.spec, rc.component, r.repair_price as repairPrice, r.repair_date as repairDate, v.number, v.model
                        from worker w
                        join repaircomponent rc on w.id = rc.repairer_id
                        join repair r on r.id = rc.repair_id
                        join person p on p.id = w.person_id
                        join vehicle v on r.vehicle_id = v.id
                        where w.team_id = ?3 and r.repair_date between ?1 and ?2
                   """,
            nativeQuery = true
    )
    List<Query15> get15Query(Date first, Date second, Long teamId);




    @Query(
            value = "Select spec , person_id as personId, team_id as teamId from Worker", nativeQuery = true
    )
    List<TestWorker> dima();

    @Query(value = "select count(*) as cnt from Worker", nativeQuery = true)
    List<TestInt> serega();




}
