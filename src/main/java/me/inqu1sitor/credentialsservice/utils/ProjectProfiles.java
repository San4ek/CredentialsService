package me.inqu1sitor.credentialsservice.utils;

/**
 * Contains possible values of {@code spring.profiles.active} property.
 *
 * @author Alexander Sankevich
 */
public class ProjectProfiles {

    /**
     * Activates {@link MailSendQueueListener RabbitMQ based RPC implementation}
     * of sending mails.
     */
    public static final String RABBIT = "rabbit";
    /**
     * Activates {@link MailControllerImpl REST API based RPC implementation}
     * of sending mails.
     */
    public static final String REST = "rest";
}
