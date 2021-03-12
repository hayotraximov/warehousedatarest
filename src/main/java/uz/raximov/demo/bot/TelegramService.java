package uz.raximov.demo.bot;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface TelegramService {

    SendMessage login(Update update);

    SendMessage shareContact(Update update);

    SendMessage katalogMenu(Update update);


    SendMessage warehouseSettings(Update update);

    SendMessage warehouseAdd(Update update);

    SendMessage warehouseAdd1(Update update);

    SendMessage warehouseEdit(Update update);

    SendMessage warehouseDelete(Update update);

    SendMessage warehouseActive(Update update);

}
