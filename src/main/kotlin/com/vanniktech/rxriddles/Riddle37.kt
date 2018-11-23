package com.vanniktech.rxriddles

import io.reactivex.Observable
import java.io.IOException
import java.lang.NullPointerException

object Riddle37 {
  /**
   * Return an Observable that emits 'false' when the [source] emits an IOException.
   *
   * Use case: You want to recover from an expected error and map them to a particular result.
   */
  fun solve(source: Observable<Boolean>): Observable<Boolean> = source.onErrorResumeNext { throwable: Throwable ->
    when (throwable) {
      is IOException -> Observable.just(false)
      else -> Observable.error(throwable)
    }
  }
}
