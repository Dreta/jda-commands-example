/*
 * JDA-Commands allows you to easily create commands in JDA.
 * This is the example Discord bot attached with JDA-Commands.
 * Copyright (C) 2020 Dreta https://dretacbe.github.io
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
import io.github.dretacbe.jdacommands.annotations.*;
import io.github.dretacbe.jdacommands.arguments.Argument;
import io.github.dretacbe.jdacommands.arguments.types.LiteralArgument;
import io.github.dretacbe.jdacommands.arguments.types.StringArgument;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.Message;

import java.util.Arrays;
import java.util.Collections;

@CommandRoot(
        name = "language",
        description = "Example command demonstrating a common use case."
)
@CommandChannel(
        channels = ChannelType.PRIVATE
)
@CommandPermissions(Permission.MANAGE_SERVER)
@CommandAliases("lang")
public class LanguageCommand extends Command {
    public LanguageCommand() {
        addPath("set", Arrays.asList(
                new Argument("set", new LiteralArgument()),
                new Argument("language", new StringArgument())
        ));
        addPath("list", Collections.singletonList(
                new Argument("list", new LiteralArgument())
        ));
        addPath("get", Collections.emptyList());
    }

    @CommandPath("set")
    public static void set(Message message, String language) {
        message.getTextChannel().sendMessage("Hey you are trying to set your language to " + language).queue();
    }

    @CommandPath("list")
    public static void list(Message message) {
        message.getTextChannel().sendMessage("Hey you are trying to list messages I think we have en_US and en_CA").queue();
    }

    @CommandPath("get")
    public static void get(Message message) {
        message.getTextChannel().sendMessage("Hey you are trying to get your language I think it's en_US").queue();
    }
}
