# -*- coding: utf-8 -*-

"""
Example code to call Rosette API to get the tokens (words) in a piece of text.
"""

import json

from rosette.api import API, DocumentParameters

def run(key):
    url = "${categories_data}"
    # Create an API instance
    api = API(user_key = key)

    params = DocumentParameters()
    params["content"] = u"${tokens_data}"
    result = api.tokens(params)

    print(json.dumps(result, indent=2, ensure_ascii=False).encode("utf8"))
    return json.dumps(result, indent=2, ensure_ascii=False).encode("utf8")
