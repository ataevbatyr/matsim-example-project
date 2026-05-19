package org.matsim.analysis;

import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.events.LinkLeaveEvent;
import org.matsim.api.core.v01.events.handler.LinkLeaveEventHandler;
import org.matsim.api.core.v01.network.Link;
import org.matsim.core.api.experimental.events.EventsManager;
import org.matsim.core.events.EventsUtils;

public class SimpleEventHandlerEx3 {
    static void main() {
        EventsManager eventsManager = EventsUtils.createEventsManager();

        LinkLeaveCounterPerHour handler =
                new LinkLeaveCounterPerHour(Id.createLinkId("123456789"));

        eventsManager.addHandler(handler);

        EventsUtils.readEvents(eventsManager,
                "/Users/batyrataev/Downloads/output_events.xml.zst");

        handler.printCounts();
    }

    public static class LinkLeaveCounterPerHour implements LinkLeaveEventHandler {

        private final Id<Link> linkId;
        private final int[] countsPerHour = new int[24];

        public LinkLeaveCounterPerHour(Id<Link> linkId) {
            this.linkId = linkId;
        }

        @Override
        public void handleEvent(LinkLeaveEvent event) {
            if (event.getLinkId().equals(linkId)) {

                int hour = (int) (event.getTime() / 3600);

                if (hour >= 0 && hour < 24) {
                    countsPerHour[hour]++;
                }
            }
        }

        public void printCounts() {
            for (int hour = 0; hour < countsPerHour.length; hour++) {
                System.out.println(
                        "Hour " + hour + ": " + countsPerHour[hour]
                );
            }
        }
    }
}
