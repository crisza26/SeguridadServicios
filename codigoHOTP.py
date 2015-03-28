import hashlib
import hmac
import struct

from . import _utils


__all__ = ( 'hotp', 'accept_hotp' )

def truncated_value(h):
    v = h[-1]
    if not isinstance(v, int): v = ord(v) # Python 2.x
    offset = v & 0xF
    (value,) = struct.unpack('>I', h[offset:offset + 4])
    return value & 0x7FFFFFFF

def dec(h,p):
    digits = str(truncated_value(h))
    return digits[-p:].zfill(p)

def int2beint64(i):
    return struct.pack('>Q', int(i))

def __hotp(key, counter, hash=hashlib.sha1):
    bin_counter = int2beint64(counter)
    bin_key = _utils.fromhex(key)

    return hmac.new(bin_key, bin_counter, hash).digest()

def hotp(key,counter,format='dec6',hash=hashlib.sha1):
    
    bin_hotp = __hotp(key, counter, hash)

    if format == 'dec4':
        return dec(bin_hotp, 4)
    elif format == 'dec6':
        return dec(bin_hotp, 6)
    elif format == 'dec7':
        return dec(bin_hotp, 7)
    elif format == 'dec8':
        return dec(bin_hotp, 8)
    elif format == 'hex':
        return '%x' % truncated_value(bin_hotp)
    elif format == 'hex-notrunc':
        return _utils.tohex(bin_hotp)
    elif format == 'bin':
        return bin_hotp
    elif format == 'dec':
        return str(truncated_value(bin_hotp))
    else:
        raise ValueError('unknown format')

def accept_hotp(key, response, counter, format='dec6', hash=hashlib.sha1,
        drift=3, backward_drift=0):

    for i in range(-backward_drift, drift+1):
        if _utils.compare_digest(hotp(key, counter+i, format=format, hash=hash), str(response)):
            return True, counter+i+1
    return False,counter
