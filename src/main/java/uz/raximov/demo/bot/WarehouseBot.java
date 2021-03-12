package uz.raximov.demo.bot;

import com.google.inject.internal.asm.$ClassWriter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import uz.raximov.demo.Entity.User;
import uz.raximov.demo.Repository.UserRepository;

import java.util.Optional;


@Component
public class WarehouseBot extends TelegramLongPollingBot {

    @Value("1291574651:AAFJ_P18j7SWLp4EuZHfDU2l1RGtaP9Op8w")
    String token;

    @Value("jafarTestBot")
    String botName;

    boolean edit = false;

    @Autowired
    TelegramService telegramService;

    @Autowired
    UserRepository userRepository;

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage()) {
            Message message = update.getMessage(); //xabar
            String text = message.getText(); //xabarni texti

            if (message.hasText()) {
                if (text.equals("/start")) {
                    execute(telegramService.login(update));
                } else {

                    Optional<User> byChatId = userRepository.findByChatId(update.getMessage().getChatId());

                    User user = byChatId.get();
                    String state = user.getState();

                    switch (state) {
                        case BotState.SHARECONTACT:
                            switch (text) {
                                case Constant.MAIN_MENU:
                                    //metodi
                                    break;
                                case Constant.KATALOG:
                                    execute(telegramService.katalogMenu(update));
                                    break;
                            }
                            break;
                        case BotState.KATALOG_MENU:
                            switch (text) {
                                case Constant.WAREHOUSE:
                                    execute(telegramService.warehouseSettings(update));
                                    //metodi
                                    break;
                                case Constant.CATEGORY:
                                    //metodi
                                    break;
                                case Constant.MEASUREMENT:
                                    //metodi
                                    break;
                                case Constant.CURRENCY:
                                    //metodi
                                    break;
                                case Constant.SUPPLIER:
                                    //metodi
                                    break;
                                case Constant.USERS:
                                    //metodi
                                    break;
                                case Constant.PRODUCT:
                                    //metodi
                                    break;
                                case Constant.BACK:
                                    user.setState(BotState.SHARECONTACT);
                                    userRepository.save(user);
                                    execute(telegramService.shareContact(update));
                                    break;
                            }
                            break;
                        case BotState.WAREHOUSE_MENU:
                            if (edit) {
                                execute(telegramService.warehouseAdd(update));
                                edit = false;
                            }
                            switch (text) {
                                case Constant.ADD:
                                    execute(telegramService.warehouseAdd(update));
                                    break;
                                case Constant.EDIT:
                                    execute(telegramService.warehouseEdit(update));
                                    edit = true;
                                    break;
                                default:
                                    if (!edit) {
                                        execute(telegramService.warehouseAdd1(update));
                                        execute(telegramService.warehouseSettings(update));
                                    }
                                    break;
                            }

                    }
                }
            } else if (message.hasContact()) {
                execute(telegramService.shareContact(update));
            } else if (message.hasLocation()) {

            } else if (message.hasPhoto()) {

            }

        }


    }

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return token;
    }
}
