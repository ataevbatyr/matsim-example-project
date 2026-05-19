package org.matsim.analysis;

import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.events.ActivityEndEvent;
import org.matsim.api.core.v01.events.handler.ActivityEndEventHandler;
import org.matsim.api.core.v01.population.Person;
import org.matsim.core.api.experimental.events.EventsManager;
import org.matsim.core.events.EventsUtils;

public class SimpleEventHandlerEx2 {
    static void main(String[] args) {
        EventsManager eventsManager = EventsUtils.createEventsManager();

        ActivityLocationPrinter handler =
                new ActivityLocationPrinter(Id.createPersonId("1")); // choose agent id

        eventsManager.addHandler(handler);

        EventsUtils.readEvents(eventsManager,
                "/Users/batyrataev/Downloads/output_events.xml.zst");
    }

    public static class ActivityLocationPrinter implements ActivityEndEventHandler {

        private final Id<Person> personId;

        public ActivityLocationPrinter(Id<Person> personId) {
            this.personId = personId;
        }

        @Override
        public void handleEvent(ActivityEndEvent event) {
            if (event.getPersonId().equals(personId)) {
                System.out.println(
                        "Person " + event.getPersonId()
                                + " ended activity at link: " + event.getLinkId()
                                + " at time: " + event.getTime()
                );
            }
        }
    }
}


