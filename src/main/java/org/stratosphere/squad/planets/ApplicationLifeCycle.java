package org.stratosphere.squad.planets;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import io.quarkus.runtime.configuration.ProfileManager;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
@Slf4j
public class ApplicationLifeCycle {

    void onStart(@Observes StartupEvent ev) {
        log.info(".    .    *  .   .  .   .  *     .  .        . .   .     .  *   .     .  .   .");
        log.info("   *  .  .____ *_  .     .    _    .    * .     ._ *  .    .   .   *   . .    .");
        log.info(".    .   / ___|| |_ _ __ __ _| |_ ___  ___ _ __ | |__ . ___ _ __ ___ .  .   * ");
        log.info("  .    * \\___ \\| __| '__/ _` | __/ _ \\/ __| '_ \\| '_ \\ / _ \\ '__/ _ \\  .  *   .");
        log.info(".  .  .   ___) | |_| | | (_| | || (_) \\__ \\ |_) | | | |  __/ | |  __/ .     .");
        log.info(" *      .|____/ \\__|_|__\\__,_|\\__\\___/|___/ .__/| | |_|\\___|_|  \\___|   *     ");
        log.info(".    *    .     . * / ___|  __ _ _   _  __|_| __| |.     .      .     *    .  .");
        log.info(" .    .      .    . \\___ \\ / _` | | | |/ _` |/ _` |  .     .-o--.   .    *  .");
        log.info(".   .     *    .     ___) | (_| | |_| | (_| | (_| |   .   :O o O :      .     .");
        log.info("____   *   .    .   |____/ \\__, |\\__,_|\\__,_|\\__,_|  .    : O. Oo;    .   .");
        log.info(" `. ````.---...___      .   * |_|      .    .      .   * . `-.O-'  .     * . .");
        log.info("   \\_    ;   \\`.-'```--..__.    .  .    .      * .     .       .     .        .");
        log.info("   ,'_,-' _,-'             ``--._    .   *   .   .  .       .   *   .     .  .");
        log.info("   -'  ,-'                       `-._ *     .       .   *  .           .    .");
        log.info("    ,-'            _,-._            ,`-. .    .   .     .      .     *    .   .");
        log.info("    '--.     _ _.._`-.  `-._        |   `_   .      *  .    .   .  /\\ .  .    .");
        log.info("        ;  ,' ' _  `._`._   `.      `,-''  `-.     .    .     .    ||     .  .");
        log.info("     ,-'   \\    `;.   `. ;`   `._  _/\\___     `.       .    *     .||  . *");
        log.info("     \\      \\ ,  `-'    )        `':_  ; \\      `. . *     .   .  /||\\   .    *");
        log.info("      \\    _; `       ,;               __;        `. .           /:||:\\    . .");
        log.info("       '-.;        __,  `   _,-'-.--'''  \\-:        `.   *   .   |:||:|  *   .");
        log.info("          )`-..---'   `---''              \\ `.        . .   .  . |/||\\|. .  .");
        log.info("        .'                                 `. `.       `  .    *   $$     .  .");
        log.info("       /                                     `. `.      ` *        $$        .");
        log.info("      /                                        `. `.     '      .   .     *");
        log.info("     /                                           `. `.   _'.  .       .  .    .");
        log.info("    |                                              `._\\-'  '     .        .  .");
        log.info("    |                                                 `.__, \\  *     .   . *. .");
        log.info("    |                                                      \\ \\.    .         .");
        log.info("    |                                                       \\ \\ .     *  .    *");
        log.info("The application is starting with profile `{}`", ProfileManager.getActiveProfile());


    }

    void onStop(@Observes ShutdownEvent ev) {
        log.info("The application PLANET is stopping...");
    }
}
