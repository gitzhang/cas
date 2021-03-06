package org.jasig.cas.web.flow.resolver;

import org.springframework.stereotype.Component;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import java.util.Set;

/**
 * This is {@link SelectiveAuthenticationProviderWebflowEventResolver}
 * that acts as a stub resolver, specifically designed for extensions.
 * Deployers can extend this class to perform additional processes on the final set
 * of resolved events, to select one vs another based on the nature of the event attributes.
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@Component("selectiveAuthenticationProviderWebflowEventResolver")
public class SelectiveAuthenticationProviderWebflowEventResolver extends AbstractCasWebflowEventResolver {
    @Override
    protected Set<Event> resolveInternal(final RequestContext context) {
        final Set<Event> resolvedEvents = getResolvedEventsAsAttribute(context);
        return resolveEventsInternal(resolvedEvents);
    }

    /**
     * Resolve events internal set. Implementation may filter events from the collection
     * to only return the one that is appropriate for this request. The default
     * implementation returns the the entire collection.
     *
     * @param resolveEvents the resolve events
     * @return the set
     */
    protected Set<Event> resolveEventsInternal(final Set<Event> resolveEvents) {
        logger.debug("Final collection of resolved events for this authentication sequence are:");
        for (final Event resolveEvent : resolveEvents) {
            logger.debug("Event id [{}] resolved from {}",
                    resolveEvent.getId(), resolveEvent.getSource().getClass().getName());
        }
        return resolveEvents;
    }
}
