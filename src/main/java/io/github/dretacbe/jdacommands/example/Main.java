/*
 * JDA-Commands allows you to easily create commands in JDA.
 * This is the example Discord bot attached with JDA-Commands.
 * Copyright (C) 2020 Dreta https://dreta.github.io
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package io.github.dretacbe.jdacommands.example;

import io.github.dretacbe.jdacommands.Command;
import io.github.dretacbe.jdacommands.CommandListener;
import io.github.dretacbe.jdacommands.Options;
import lombok.SneakyThrows;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        JDA jda = JDABuilder.createDefault(System.getenv("DISCORD_TOKEN"))
                .addEventListeners(new CommandListener())
                .setActivity(Activity.playing("with jda-commands"))
                .build();
        jda.awaitReady();
        Command.init(Options.builder()
                .guild(jda.getGuildById("740517639419461673"))  // That's the "Dreta Bot Test" guild - not open to the public
                .prefix("!")
                .errorEmbed(true)  // Because embeds look nice
                .build());
        new PingCommand();
        new LanguageCommand();
    }
}
