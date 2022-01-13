/*
 * Copyright (C) 2019 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.squareup.picasso

import android.graphics.Bitmap
import java.io.Closeable

interface EventListener : Closeable {
  fun cacheHit(key: String)
  fun cacheMiss(key: String)
  fun downloadFinished(key: String, size: Long)
  fun bitmapDecoded(key: String, bitmap: Bitmap)
  fun bitmapTransformed(key: String, bitmap: Bitmap)
  override fun close() = Unit
  fun huntStarted(key: String)
  fun huntEnded(key: String, success: Boolean, loadedFrom: Picasso.LoadedFrom)
}
