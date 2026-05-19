package org.matsim.analysis;

import org.matsim.api.core.v01.events.LinkLeaveEvent;
import org.matsim.api.core.v01.events.handler.LinkLeaveEventHandler;
import org.matsim.core.api.experimental.events.EventsManager;
import org.matsim.core.events.EventsUtils;

public class SimpleEventHandlerEx1 {
    // psvm
    static void main() {
        EventsManager eventsManager = EventsUtils.createEventsManager();

        SimpleLeaveCounter handler = new SimpleLeaveCounter();
        eventsManager.addHandler(handler);

        int countBefore = handler.getCounter();

        EventsUtils.readEvents(eventsManager,"/Users/batyrataev/Downloads/output_events.xml.zst");

        int countAfter = handler.getCounter();

        System.out.println("Count before " + countBefore);
        System.out.println("Count before " + countAfter);

    }

    public static class SimpleLeaveCounter implements LinkLeaveEventHandler {

        private int counter = 0;

        @Override
        public void handleEvent(LinkLeaveEvent event) {
            System.out.println("Counter status: " + counter);
            counter++;
        }
        public int getCounter(){
            return counter;
        }
    }
}
