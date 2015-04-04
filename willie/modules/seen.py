# coding=utf8
"""
seen.py - Willie Seen Module
Copyright 2008, Sean B. Palmer, inamidst.com
Copyright © 2012, Elad Alfassa <elad@fedoraproject.org>
Licensed under the Eiffel Forum License 2.

http://willie.dftba.net
"""
from __future__ import unicode_literals

import time
import datetime
from willie.tools import Identifier
from willie.tools.time import get_timezone, format_time
from willie.module import commands, rule, priority, thread


@commands('seen')
def seen(bot, trigger):
    """Reports when and where the user was last seen."""
    if not trigger.group(2):
        bot.say(".seen <nick> - Reports when <nick> was last seen.")
        return
    nick = trigger.group(2).strip()
    timestamp = bot.db.get_nick_value(nick, 'seen_timestamp')
    if timestamp:
        channel = bot.db.get_nick_value(nick, 'seen_channel')
        message = bot.db.get_nick_value(nick, 'seen_message')

        tz = get_timezone(bot.db, bot.config, None, trigger.nick,
                          trigger.sender)
        saw = datetime.datetime.utcfromtimestamp(timestamp)
        timestamp = format_time(bot.db, bot.config, tz, trigger.nick,
                                trigger.sender, saw)

        msg = "I last saw {} at {}".format(nick, timestamp)
        if Identifier(channel) == trigger.sender:
            msg = msg + " in here, saying " + message
        else:
            msg += " in another channel."
        bot.say(str(trigger.nick) + ': ' + msg)
    else:
        bot.say("Sorry, I haven't seen {} around.".format(nick))


@thread(False)
@rule('(.*)')
@priority('low')
def note(bot, trigger):
    if not trigger.is_privmsg:
        bot.db.set_nick_value(trigger.nick, 'seen_timestamp', time.time())
        bot.db.set_nick_value(trigger.nick, 'seen_channel', trigger.sender)
        bot.db.set_nick_value(trigger.nick, 'seen_message', trigger)
