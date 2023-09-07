package com.young.gof.buider;

import java.time.LocalDate;

import com.young.gof.builder.DefaultTourPlanBuilder;
import com.young.gof.builder.TourDirector;
import com.young.gof.builder.TourPlan;
import com.young.gof.builder.TourPlanBuilder;
import org.junit.jupiter.api.Test;

public class BuilderTests {

    @Test
    void test_builder(){
        TourPlanBuilder builder = new DefaultTourPlanBuilder();
        TourPlan plan = builder.title("칸쿤 여행").nightsAndDays(2, 3).startDate(LocalDate.of(2023, 12, 31))
                .whereToStay("리조트").addPlan(0, "checked in").addPlan(0, "저녁식사")
                .getPlan();

    }
    @Test
    void test_director(){
        TourDirector tourDirector = new TourDirector(new DefaultTourPlanBuilder());
        TourPlan tourPlan = tourDirector.cancunTrip();
        TourPlan tourPlan1 = tourDirector.longBeachTrip();
    }
}
