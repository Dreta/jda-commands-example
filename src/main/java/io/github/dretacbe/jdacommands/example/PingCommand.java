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
import io.github.dretacbe.jdacommands.arguments.types.MemberArgument;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Message;

import java.util.Collections;

@CommandRoot(  // Mandatory
        name = "ping",  // Mandatory
        description = "Ping ping ping!"  // Optional
)
@CommandChannel(  // Optional
        value = "740517642540154893"  // Optional (Dreta Bot Test #general)
)
@CommandPermissions({Permission.MESSAGE_READ, Permission.MESSAGE_WRITE})  // Optional
@CommandAliases("pong")  // Optional
public class PingCommand extends Command {
    public PingCommand() {
        addPath("me", Collections.emptyList());
        addPath("you", PingYou.class, Collections.singletonList(
                new Argument("who", new MemberArgument())
        ));
    }

    @CommandPath("me")
    public static void me(Message message) {  // Can also be static if desired.
        message.getTextChannel().sendMessage(message.getMember().getAsMention() + ", pong!").queue();
    }
}
